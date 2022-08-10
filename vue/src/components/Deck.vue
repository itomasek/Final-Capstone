<template>
  <div>
    <div id="deck-container">
      <h1 class="deck-name">{{ deck.name }}</h1>
      <h4 class="deck-subject">{{ deck.subject }}</h4>
      <br />
      <p class="deck-description">{{ deck.description }}</p>
      <button class="edit-button">Edit Deck</button>
      <h6 class="number-of-cards">Number Of Cards: {{numberOfCards}}</h6>
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
  updated() {
    CardService.getNumberOfCards(this.deck.deckId).then((response) => {
      this.numberOfCards = response.data;
    });
  },
};
</script>

<style>
#deck-container {
  font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas:
    "name . subject"
    "description description description"
    "edit . number";
  border: solid black 2px;
  padding: 50px;
  margin: 50px;
  border-radius: 30px;
  background-color: #C9E3DA;
  width: 400px;
}

.deck-name {
  grid-area: name;
  text-decoration: underline;
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
}
</style>