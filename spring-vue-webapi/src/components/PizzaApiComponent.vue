<template>
  <div>
    <h1>Pizzas</h1>

    <div class="container">
      <div class="row">
        <div class="col">
          <table class="table table-primary">
            <tr>
              <th>Name</th>
              <th>Description</th>
              <th>Price</th>
              <th>Ingredients</th>
              <th>Available actions</th>
            </tr>
            <tr class="text-center" v-for="pizza in pizzas" :key="pizza.id">
              <td>{{ pizza.name }}</td>
              <td>{{ pizza.description }}</td>
              <td>{{ pizza.price }}</td>
              <td>{{ pizza.ingredients }}</td>
              <td>
                <a class="btn btn-warning text-decoration-none">Modify</a>
                <a class="btn btn-danger">Delete</a>
              </td>
            </tr>
          </table>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

const API_URL = "http://localhost:8080/api/1";
const pizzas_id = -1;

export default {
  name: "PizzaApiComponent",
  data() {
    return {
      pizzas: [],
      pizzas_edit_id: pizzas_id,
    };
  },
  methods: {
    getPizzas() {
      axios
        .get(API_URL + "/pizza/all")
        .then((res) => {
          const allPizzas = res.data;
          console.table(allPizzas);
          if (allPizzas == null) return;
          this.pizzas = allPizzas;
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
  mounted() {
    this.getPizzas();
  },
};
</script>

<style scoped>
</style>
