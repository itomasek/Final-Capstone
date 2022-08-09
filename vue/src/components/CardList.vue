<template>
  <div class="cards-container">
      <card v-for="card in cards" v-bind:key="card.cardId" v-bind:card="card"/>
  </div>
</template>

<script>

import CardService from '../services/CardService.js';
import Card from '../components/Card.vue';

export default {
  name: "card-list",
  components: {
    Card
  },
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
.cards-container{
  display: flex;
  justify-content: space-around;
}
</style>