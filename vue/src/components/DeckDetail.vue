<template>
  <div>
    <form class="edit-deck-form">
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
      <button class="edit-deck" type="submit" v-on:click.prevent="saveEdits">
        Save Changes
      </button>
      <br>
      <button class="edit-deck" v-on:click.prevent="deleteDeck">Delete This Deck</button>
      <br />
      <button class="cancel-edit-deck" v-on:click.prevent="cancelForm">Cancel</button>
    </form>
    <hr />
    <div id="card-container">
      <div id="cards-in-deck">
        <h3>Cards Currently In This Deck:</h3>
        <deck-card
          v-for="card in inCards"
          v-bind:key="card.cardId"
          v-bind:card="card"
        />
      </div>

      <div id="cards-not-in-deck">
        <h3>Cards Not Currently In This Deck:</h3>
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
      createResponse: "",
      createError: "",
    };
  },
  methods: {
    saveEdits() {
      console.log("current deck is:" + this.deck.deckId);
      CardService.clearCardDeck(this.deck.deckId);
      CardService.updateDeck(this.deck.deckId, this.deck);
      if (this.$store.state.cardIdsToAdd.length > 0) {
        this.$store.state.cardIdsToAdd.forEach((Id) => {
          CardService.putCardsInDeck(Id, this.deck.deckId)
            .then((response) => {
              this.createResponse = response.statusText;
            })
            .catch((error) => {
              this.createError = error.statusText;
            });
        });
      }
      this.$store.commit("CLEAR_CARD_IDS");
      this.$router.push({
        name: "my-decks",
        params: { user_id: this.deck.userId },
      });
      this.$store.commit("CLEAR_EDIT_DECK");
    },
    cancelForm() {
      this.$store.commit("CLEAR_CARD_IDS");
      this.$store.commit("CLEAR_EDIT_DECK");
      this.$router.push({
        name: "my-decks",
        params: { user_id: this.deck.userId },
      });
    },
    deleteDeck() {
      CardService.clearCardDeck(this.deck.deckId);
      CardService.deleteDeck(this.deck.deckId);
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
      this.inCards.forEach((card) => {
        this.$store.commit("ADD_CARD_ID", card.cardId);
      });
    });
    CardService.getExcludedCards(this.deck.userId, this.deck.deckId).then(
      (response) => {
        this.outCards = response.data;
      }
    );
  },
};
</script>

<style scoped>
.edit-deck-form {
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
  text-align: center;
}
#card-container {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas: "in out";
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
}

#cards-in-deck {
  grid-area: in;
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  align-items: center;
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
  border-right: solid black 2px;
}

#cards-not-in-deck {
  grid-area: out;
  display: flex;

  flex-direction: column;
  flex-wrap: wrap;
  align-items: center;
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
}
.edit-deck {
  margin: 5px auto;
  width: 150px;
  background-color: #deebf3;
  border-radius: 5px;
}
.cancel-edit-deck {
  margin: 5px auto;
  width: 150px;
  background-color: #deebf3;
  border-radius: 5px;
}
textarea {
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
}
</style>