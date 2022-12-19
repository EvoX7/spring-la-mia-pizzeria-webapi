<template>
  <div>
    <h1>Pizze</h1>
    <div v-if="!pizza_create_form">
      <button @click="pizza_create_form = true">CREATE NEW PIZZA</button>
    </div>
    <div v-else>
      <form @submit="createPizza">
        <label for="name">Name</label>
        <input type="text" name="name" v-model="pizza_create.name" />
        <br />
        <label for="description">Description</label>
        <input
          type="text"
          name="description"
          v-model="pizza_create.description"
        />
        <br />
        <label for="price">Price</label>
        <input type="number" name="price" v-model="pizza_create.price" />
        <br /><br />
        <input type="submit" value="CREATE" />
        <button @click="editPizza(pizzasEditId)">CANCEL</button>
      </form>
    </div>
    <ul>
      <li v-for="pizza in pizzas" :key="pizza.id">
        <div v-if="pizzas_edit_id != pizza.id">
          {{ pizza.name }}
          <br />
          <div v-if="!pizza.ingredients">
            <button @click="getIngrediensi(pizza.id)">GET INGREDIENTS</button>
          </div>
          <div v-else>
            <ul v-if="pizza.ingredients.length > 0">
              <li
                v-for="ingredient in pizza.ingredients"
                :key="ingredient.id"
              >
                {{ ingredient.name }}
              </li>
            </ul>
          </div>
          <br />
          <button @click="editPizza(pizza.id)">EDIT</button>
          <br />
          <button @click="deletePizza(pizza.id)">DELETE</button>
        </div>
        <div v-else>
          <form @submit="updatePizza">
            <label for="name">Name</label>
            <input type="text" name="name" v-model="pizza.name" />
            <br />
            <label for="description">Description</label>
            <input type="text" name="description" v-model="pizza.description" />
            <br />
            <label for="price">Price</label>
            <input type="number" name="price" v-model="pizza.price" />
            <br /><br />
            <input type="submit" value="UPDATE" />
            <button @click="editPizza(pizzasEditId)">CANCEL</button>
          </form>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

const API_URL = "http://localhost:8080/api/1";

const pizzasEditId = -1;

export default {
  name: 'PizzeComp',
  data() {

    return {

      pizzas: [],
      pizze_edit_id: pizzasEditId,
      pizza_create: { },
      pizza_create_form: false, 
    };
  },
  methods: {
    getPizzaIndexById(id) {
      for (let x = 0; x < this.pizzas.length; x++) {
        const pizza = this.pizzas[x];
        if (pizza.id == id) return x;
      }

      return -1;
    },
    getPizzaById(id) {
      return this.pizzas[this.getPizzaIndexById(id)];
    },
    createPizza(e) {
      e.preventDefault();

      axios.post(API_URL + "/pizza/create", this.pizza_create).then((res) => {
        const pizza = res.data;

        if (pizza == null) return;

        this.pizzas.push(pizza);
      });
    },
    editPizza(id) {
      this.pizzas_edit_id = id;
    },
    updatePizza(e) {
      e.preventDefault();

      const id = this.pizzas_edit_id;
      const pizza = this.getPizzaById(id);

      this.editPizza(pizzasEditId);

      axios.post(API_URL + "/pizza/update/" + id, pizza).then((res) => {
        const index = this.getPizzaIndexById(id);
        const oldPizza = this.pizzas[index];

        const pizza = res.data;
        pizza.ingredients = oldPizza.ingredients;

        this.pizzas[index] = pizza;
      });
    },
    getIngredients(id) {
      axios.get(API_URL + "/ingredients/by/pizza/" + id).then((res) => {
        const ingredients = res.data;

        if (ingredients == null) return;

        const index = this.getPizzaIndexById(id);
        this.pizzas[index].ingredients = ingredients;
      });
    },
    deletePizza(id) {
      console.log(id);

      axios.get(API_URL + "/pizza/delete/" + id).then((res) => {
        const deleted = res.data;

        if (!deleted) return;

        const index = this.getPizzaIndexById(id);
        this.pizzas.splice(index, 1);
      });
    },
  },
  mounted() {
    axios.get(API_URL + "/pizza/all").then((res) => {
      const pizzas = res.data;
      if (pizzas == null) return;

      this.pizzas = pizzas;
    });
  },
};
</script>

<style scoped>
</style>