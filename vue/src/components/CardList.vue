<template>
  <div>
    <h1>Your Cards So Far:</h1>
    <div id="filter-bar">
      <label for="filter-cards">Filter By Tags: </label>
      <br />
      <input type="text" name="filter-cards" v-model="filter" />
      
    </div>
    <div class="cards-container">
      <card v-for="card in filteredCards" v-bind:key="card.cardId" v-bind:card="card" />
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
</script>

<style>
.cards-container {
  
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  margin-left: 300px;
}

h1 {
  font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
  text-align: center;
}

#filter-bar {
  font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
  margin-left: 300px;
}
</style>