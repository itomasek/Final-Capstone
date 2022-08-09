<template>
  <div class="home">
    <div class="main-container">
      <h1>Welcome To</h1>
      <h1>FlashCard Study App</h1>
      <h3>Some Sort Of Catchphrase!</h3>
      <p>Check Out These Example Cards, The Answers Can Be Viewed By Pressing 'Flip'</p>
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
  background-color: cadetblue;
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
