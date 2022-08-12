<template>
  <div>
    <div id="deck-container">
      <h2 class="deck-name">{{ deck.name }}</h2>
      <h4 class="deck-subject">{{ deck.subject }}</h4>
      <br />
      <p class="deck-description">{{ deck.description }}</p>
      <button class="edit-button" v-on:click="editDeck">Edit Deck</button>
      <h6 class="number-of-cards">Number Of Cards: {{ numberOfCards }}</h6>
    </div>
  </div>
</template>

<script>
import CardService from "../services/CardService.js";

export default {
  name: "deck",
  props: ["deck"],
  data() {
    return {
      numberOfCards: 0,
    };
  },
  computed: {
    username() {
      return this.$store.state.user.username;
    },
  },
  created() {
    CardService.getNumberOfCards(this.deck.deckId).then((response) => {
      this.numberOfCards = response.data;
    });
  },
  methods: {
    editDeck() {
      this.$store.commit("SET_EDIT_DECK", this.deck);
      this.$router.push({
        name: "deck-detail",
        params: { deck_id: this.deck.deckId },
      });
    },
  },
};
</script>

<style>
#deck-container {
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-rows: 1fr 1fr 1fr;
  grid-template-areas:
    "name . subject"
    "description description description"
    "edit . number";
  border: solid black 2px;
  padding: 50px;
  margin: 50px;
  border-radius: 30px;
  background-color: #c9e3da;
  width: 400px;
  height: 300px;
}

.deck-name {
  grid-area: name;
}

.deck-subject {
  grid-area: subject;
}

.deck-description {
  grid-area: description;
}

.number-of-cards {
  grid-area: number;
}

.edit-button {
  grid-area: edit;
  border-radius: 10px;
  width: 125px;
  height: 50px;
}
</style>