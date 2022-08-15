<template>
  <div>
    <h1>Your Decks:</h1>
    <h4 class="decks-subline">
      Select A Deck To Edit Or Begin A Study Session
    </h4>
    <hr />
    <p v-if="this.decks.length == 0">You Don't Have Any Decks Yet!</p>
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
  }
};
</script>

<style>
p,
h2,
h1 {
  text-align: center;
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
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

.decks-subline {
  text-align: center;
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
}
</style>