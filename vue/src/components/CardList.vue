<template>
  <div>
    <h1>Your Cards So Far:</h1>
    <div class="cards-container">
      <card v-for="card in cards" v-bind:key="card.cardId" v-bind:card="card" />
    </div>
  </div>
</template>

<script>
import CardService from "../services/CardService.js";
import Card from "../components/Card.vue";

export default {
  name: "card-list",
  components: {
    Card,
  },
  data() {
    return {
      cards: [],
    };
  },
  created() {
    CardService.listCards(this.$store.state.user.id).then((response) => {
      this.cards = response.data;
    });
  },
};
</script>

<style>
.cards-container {
  display: flex;
  justify-content: space-around;
  margin-left: 300px;
}

h1 {
  text-align: center;
}
</style>