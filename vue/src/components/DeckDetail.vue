<template>
  <div>
    <form class="edit-deck-form" v-on:submit.prevent>
      <h1>Edit Deck Details</h1>
      <div>
        <label for="name">Deck Name: </label>
        <br />
        <input type="text" name="name" v-model.trim="deck.name" />
      </div>
      <div>
        <label for="subject">Deck Subject: </label>
        <br />
        <input type="text" name="subject" v-model.trim="deck.subject" />
      </div>
      <div>
        <label for="description">Deck Description</label>
        <br />
        <textarea
          name="description"
          cols="30"
          rows="10"
          v-model.trim="deck.description"
        ></textarea>
      </div>
      <button class="edit-button" type="submit" v-on:click.prevent="saveEdits">
        Save Changes
      </button>
      <button class="cancel-edit-button" v-on:click="cancelForm">Cancel</button>
    </form>
    <hr />
    <div id="card-container">
      <div id="cards-in-deck">
        <h3>Cards Currently In This Deck: </h3>
        <deck-card
          v-for="card in inCards"
          v-bind:key="card.cardId"
          v-bind:card="card"
        />
      </div>
      <div id="cards-not-in-deck">
        <h3>Cards Not Currently In This Deck: </h3>
        <deck-card
          v-for="card in outCards"
          v-bind:key="card.cardId"
          v-bind:card="card"
        />
      </div>
    </div>
  </div>
</template>

<script>
import CardService from "../services/CardService";
import DeckCard from "./DeckCard.vue";
export default {
  components: { DeckCard },
  name: "edit-deck-form",
  data() {
    return {
      deck: {
        deckId: null,
        name: "",
        subject: "",
        description: "",
        userId: this.$store.state.user.id,
      },
      inCards: [],
      outCards: [],
    };
  },
  methods: {
    saveEdits() {},
    cancelForm() {
      this.$router.push({
        name: "my-decks",
        params: { user_id: this.deck.userId },
      });
    },
  },
  created() {
    this.deck = this.$store.state.activeEditDeck;
    CardService.getCardsByDeckId(this.deck.deckId).then((response) => {
      this.inCards = response.data;
    });
    CardService.getExcludedCards(this.deck.deckId).then((response) => {
      this.outCards = response.data;
    });
    this.inCards.forEach((card) => {
      this.$store.commit("ADD_CARD_ID", card.cardId);
    });
  },
  updated() {
    this.deck = this.$store.state.activeEditDeck;
    CardService.getCardsByDeckId(this.deck.deckId).then((response) => {
      this.inCards = response.data;
    });
    CardService.getExcludedCards(this.deck.deckId).then((response) => {
      this.outCards = response.data;
    });
    this.inCards.forEach((card) => {
      this.$store.commit("ADD_CARD_ID", card.cardId);
    });
  },
};
</script>

<style scoped>
#card-container {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas: "in out";
}

#cards-in-deck {
  grid-area: in;
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  align-items: center;
}

#cards-not-in-deck {
  grid-area: out;
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  align-items: center;
}
</style>