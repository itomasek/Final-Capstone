<template>
  <div>
    <h1 class="title">Current Cards:</h1>
    <div id="filter-bar">
      <label for="filter-cards">Search By Tags: </label>
      <br />
      <input
        class="filter-bar"
        type="text"
        name="filter-cards"
        v-model="filter"
      />
    </div>
    <div class="cards-container">
      <card
        v-for="card in filteredCards"
        v-bind:key="card.cardId"
        v-bind:card="card"
      />
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
</script >

<style>
.cards-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
}

h1 {
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
  text-align: center;
}
.title {
  font-size: 75px;
  text-decoration: underline;
}

#filter-bar {
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
  margin: auto;
  text-align: center;
  font-size: 50px;
  
}
.filter-bar {
  padding: 10px 50px 10px 50px;
  border-radius: 5px;
}
</style>