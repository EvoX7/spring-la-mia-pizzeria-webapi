<template>
  <div>
    <h1>Pizze</h1>

    <ul>
      <li v-for="pizza in pizzas" :key="pizza.id"></li>
    </ul>
  </div>
</template>

<script>
import axios from "axios";

const API_URL = "http://localhost:8080/api/1";

export default {
  name: "PizzaApiComponent",
  data() {
    return {
      pizzas: [],
    };
  },
  methods: {
    getPizzas() {
      axios
        .get(API_URL + "/pizza/all")
        .then((res) => {
          console.log(res);
          const allPizzas = res.data;
          if (allPizzas == null) return;
          this.pizzas = allPizzas;
          console.log(this.pizzas);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    mounted() {
      this.getPizzas();
    },
  },
 
};

</script>

<style scoped>
</style>