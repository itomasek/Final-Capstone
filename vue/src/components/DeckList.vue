<template>
  <div>
    <h1>Your Decks So Far:</h1>
    <div class="deck-container">
      <deck v-for="deck in decks" v-bind:key="deck.deckId" v-bind:deck="deck" />
    </div>
  </div>
</template>

<script>
import CardService from "../services/CardService.js";
import Deck from "../components/Deck.vue";

export default {
  name: "deck-list",
  components: { Deck },
  data() {
    return {
      decks: [],
    };
  },
  created() {
    CardService.listDecks(this.$store.state.user.id).then((response) => {
      this.decks = response.data;
    });
  },
  updated() {
    CardService.listDecks(this.$store.state.user.id).then((response) => {
      this.decks = response.data;
    });
  },
};
</script>

<style>
</style>