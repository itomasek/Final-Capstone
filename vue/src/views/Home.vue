<template>
  <div class="home">
    <div class="main-container">
      <h1>Welcome to <em> FLASHDEX</em>!</h1>
      <h3>Improving your brain one flashcard at a time!</h3>
      <p>
        Check out these example cards! The answers can be viewed by pressing
        'Flip'.
      </p>
    </div>
    <div id="filter-bar">
      <label for="filter-cards">Search By Tags: </label>
      <br />
      <input
        placeholder="Ex: History, Culture, Music"
        class="filter-bar"
        type="text"
        name="filter-cards"
        v-model="filter"
      />
    </div>
    <div class="example-container">
      <card
        v-for="card in filteredCards"
        v-bind:key="card.cardId"
        v-bind:card="card"
      />
    </div>
  </div>
</template>

<script>
import Card from "../components/Card.vue";
export default {
  components: { Card },
  name: "home",
  data() {
    return {
      cards: [],
      filter: "",
    };
  },
  created() {
    this.cards = this.$store.state.exampleCards;
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
.home {
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
}

h1 {
  font-weight: bold;
  font-size: 300%;
}

.example-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
}

.main-container {
  text-align: center;
}

</style>
