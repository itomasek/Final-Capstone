<template>
  <div>
    <div id="deck-container">
      <h2 class="deck-name">{{ deck.name }}</h2>
      <h4 class="deck-subject">{{ deck.subject }}</h4>
      <br />
      <p class="deck-description">{{ deck.description }}</p>
      <div class="study-edit">
        <button class="edit-button" v-on:click="editDeck">Edit Deck</button>
        <button class="study-button" v-on:click="goStudy" v-show="showStudy">Study This Deck</button>
      </div>
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
    showStudy() {
      return (this.numberOfCards > 0) ? true : false;
    }
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
  methods: {
    editDeck() {
      this.$store.commit("SET_EDIT_DECK", this.deck);
      this.$router.push({
        name: "deck-detail",
        params: { deck_id: this.deck.deckId },
      });
    },
    goStudy() {
      this.$store.commit('SET_ACTIVE_DECK', this.deck.deckId);
      this.$store.commit('SET_ACTIVE_DECK_NAME', this.deck.name);
      
      this.$router.push({name: 'study-session'});
    }
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
  
  width: 400px;
  height: 300px;
  background-image: url("../../assets/Question.png");
  background-repeat: no-repeat;
  background-size: cover;
  font-weight: bold;
  background-blend-mode: color-burn;
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

.study-edit {
  grid-area: edit;
  display: flex;
  flex-direction: column;
}

.edit-button {
  border-radius: 10px;
  width: 125px;
  height: 50px;
}

.study-button {
  border-radius: 10px;
  width: 125px;
  height: 50px;
  margin-top: 15px;
}
</style>