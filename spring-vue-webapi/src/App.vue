<template>
  <PizzaApiComponent />
</template>

<script>
import PizzaApiComponent from "./components/PizzaApiComponent.vue";


export default {
  name: "App",
  components: {
    PizzaApiComponent,
  },
};
</script>

<style lang="scss">
@import "~bootstrap/scss/bootstrap.scss";
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
