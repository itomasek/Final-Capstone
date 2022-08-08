<template>
  <div>
      <h1 v-for="card in cards" v-bind:key="card.cardId">{{card.question}}</h1>
  </div>
</template>

<script>

import CardService from '../services/CardService.js';

export default {
  name: "card-list",
  data() {
    return {
      cards: [],
    };
  },
  created(){
      CardService.listCards(this.$store.state.user.id).then((response) => {
          this.cards = response.data;
      })
  }
};
</script>

<style>
</style>