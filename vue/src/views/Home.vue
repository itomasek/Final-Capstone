<template>
  <div class="home">
    <div class="main-container">
      <h1>Welcome to Flashdex!</h1>
      <h3>Improving your brain one flashcard at a time!</h3>
      <p>Check out these example cards! The answers can be viewed by pressing 'Flip'.</p>
    </div>
    <div class="example-container">
      <card v-for="card in this.$store.state.exampleCards"
      v-bind:key="card.cardId" v-bind:card="card" />
    </div>
  </div>
</template>

<script>
import Card from "../components/Card.vue";
export default {
  components: { Card },
  name: "home",
};
</script>

<style>
.home {
  margin-left: 250px;
  background-color: #F6FBFF;
  font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
}

h1{
  font-weight: bold;
  font-size: 300%;
}

.example-container {
  display: flex;
  flex-wrap: nowrap;
  justify-content: space-around;
  
}

.main-container {
  text-align: center;
}
</style>
