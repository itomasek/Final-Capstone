<template>
  <div>
    <h1>Your Decks:</h1>
    <p v-if="this.decks.length == 0">You Don't Have Any Decks Yet!</p>
    <div class="deck-container">
      <deck v-for="deck in decks" v-bind:key="deck.deckId" v-bind:deck="deck" />
    </div>
    <hr />
    <h2>Example Decks:</h2>
    <div class="example-deck-container">
      <deck
        v-for="deck in exampleDecks"
        v-bind:key="deck.deckId"
        v-bind:deck="deck"
      />
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
      exampleDecks: [],
    };
  },
  created() {
    CardService.listDecks(this.$store.state.user.id).then((response) => {
      this.decks = response.data;
    });
    CardService.listDecks(2).then((response) => {
      this.exampleDecks = response.data;
    });
  },
  updated() {
    CardService.listDecks(this.$store.state.user.id).then((response) => {
      this.decks = response.data;
    });
    CardService.listDecks(2).then((response) => {
      this.exampleDecks = response.data;
    });
  },
};
</script>

<style>
p,
h2, h1 {
  text-align: center;
}

.deck-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  margin: auto;
}

.example-deck-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  margin: auto;
}
</style>