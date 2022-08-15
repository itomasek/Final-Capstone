<template>
  <div>
    <h1>Edit Deck Details</h1>
    <form class="edit-deck-form">
      <div class="name-div-edit-deck">
        <label for="name">Deck Name: </label>
        <br />
        <input class="name-edit-deck" type="text" name="name" v-model.trim="deck.name" />
      </div>
      <div class="sub-div-edit-deck">
        <label for="subject">Deck Subject: </label>
        <br />
        <input class="subject-edit-deck" type="text" name="subject" v-model.trim="deck.subject" />
      </div>
      <div class="desc-div-edit-deck">
        <label for="description">Deck Description</label>
        <br />
        <textarea
          class="desc-edit-deck"
          name="description"
          cols="50"
          rows="10"
          v-model.trim="deck.description"
        ></textarea>
      </div>
      <div class="button-div-edit-deck">
        <button
          class="save-button-edit-deck"
          type="submit"
          v-on:click.prevent="saveEdits"
        >
          Save Changes
        </button>
        <button class="delete-button-edit-deck" v-on:click.prevent="deleteDeck">
          Delete This Deck
        </button>
        <button class="cancel-button-edit-deck" v-on:click.prevent="cancelForm">
          Cancel
        </button>
      </div>
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

.edit-deck-form {
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
  text-align: center;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-areas:
    ". name subject ."
    ". desc desc ."
    ". button button .";
}

.name-div-edit-deck {
  grid-area: name;
}

.name-edit-deck {
  padding: 10px 50px 10px 50px;
  border-radius: 5px;
  box-shadow: 5px 5px 5px #c7e1f1;
}

.sub-div-edit-deck {
  grid-area: subject;
}

.subject-edit-deck {
  padding: 10px 50px 10px 50px;
  border-radius: 5px;
  box-shadow: 5px 5px 5px #c7e1f1;
}

.desc-div-edit-deck {
  grid-area: desc;
  margin-top: 20px;
}

.desc-edit-deck {
  padding: 10px 50px 10px 50px;
  border-radius: 5px;
  box-shadow: 5px 5px 5px #c7e1f1;
  resize: none;
  text-align: center;
}

.button-div-edit-deck {
  grid-area: button;
  display: flex;
  justify-content: space-around;
}

.save-button-edit-deck {
  border-radius: 10px;
  width: 125px;
  height: 50px;
  margin: 10px;
  margin-left: 100px;
  padding: 10px;
  font-weight: 700;
}

.delete-button-edit-deck {
  border-radius: 10px;
  width: 125px;
  height: 50px;
  margin: 10px;
  
  padding: 10px;
  font-weight: 700;
}

.cancel-button-edit-deck {
  border-radius: 10px;
  width: 125px;
  height: 50px;
  margin: 10px;
  margin-right: 100px;
  padding: 10px;
  font-weight: 700;
}

textarea {
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
}
</style>