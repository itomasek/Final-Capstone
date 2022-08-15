<template>
  <div>
    <h1>Add Cards To Your New Deck: </h1>
    <div id="filter-bar">
      <label for="filter-cards">Filter By Tags: </label>
      <br />
      <input placeholder="Ex: History, Culture, Music" class="filter-bar" type="text" name="filter-cards" v-model="filter" />
    </div>
    <div class="deck-cards-container">
      <deck-card
        v-for="card in filteredCards"
        v-bind:key="card.cardId"
        v-bind:card="card"
      />
    </div>
  </div>
</template>

<script>
import CardService from "../services/CardService.js";
import DeckCard from "../components/DeckCard.vue";

export default {
  name: "deck-card-list",
  components: { DeckCard },
  data() {
    return {
      cards: [],
      filter: "",
    };
  },
  created() {
    CardService.listCards(this.$store.state.user.id).then((response) => {
      this.cards = response.data;
    });
  },
  updated() {
    CardService.listCards(this.$store.state.user.id).then((response) => {
      this.cards = response.data;
    });
  },
  computed: {
    filteredCards() {
      return this.cards.filter((card) => {
        return card.tags.toLowerCase().includes(this.filter.toLowerCase());
      });
    },
  },
};
</script>

<style>
.deck-cards-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  
}

h1 {
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
  text-align: center;
}

#filter-bar {
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
  margin:auto;
  text-align: center;
  font-size: 50px;
}
.filter-bar{
  padding: 10px 50px 10px 50px;
}
</style>