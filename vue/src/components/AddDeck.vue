<template>
  <div>
    <h1>New Deck Form</h1>
    <form class="new-deck-form" v-on:submit.prevent>
      <div class="name-div-add-deck">
        <label for="name">Deck Name: </label>
        <br />
        <input class="name-add-deck" type="text" name="name" v-model="deck.name" placeholder="Give This Deck A Name!"/>
      </div>
      <div class="subject-div-add-deck">
        <label for="subject">Deck Subject: </label>
        <br />
        <input class="subject-add-deck" type="text" name="subject" v-model="deck.subject" placeholder="What Is This Deck About?"/>
      </div>
      <div class="desc-div-add-deck">
        <label for="description">Deck Description</label>
        <br />
        <textarea
          placeholder="Give This Deck A Description!"
          class="desc-add-deck"
          name="description"
          cols="50"
          rows="10"
          v-model="deck.description"
        ></textarea>
      </div>
      <div class="add-deck-buttons">
        <button class="save-add-deck" type="submit" v-on:click.prevent="saveDeck">
          Save New Deck
        </button>
        <button class="cancel-add-deck" v-on:click="cancelForm">Cancel</button>
      </div>
    </form>
    <hr />
    <deck-card-list />
  </div>
</template>

<script >
import CardService from "../services/CardService";
import DeckCardList from "./DeckCardList.vue";
export default {
  components: { DeckCardList },
  name: "new-deck-form",
  data() {
    return {
      deck: {
        deckId: null,
        name: "",
        subject: "",
        description: "",
        userId: this.$store.state.user.id,
      },
      newDeckId: null,
      createResponse: null,
      createError: null,
    };
  },
  methods: {
    saveDeck() {
      CardService.createDeck(this.deck).then((response) => {
        if (response.status == 200) {
          this.deck = {
            deckId: null,
            name: "",
            subject: "",
            description: "",
            userId: this.$store.state.user.id,
          };
          this.newDeckId = response.data;
          if (this.$store.state.cardIdsToAdd.length > 0) {
            this.$store.state.cardIdsToAdd.forEach((Id) => {
              CardService.putCardsInDeck(Id, this.newDeckId)
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
        }
      });
    },
    cancelForm() {
      this.$router.push({ name: "home" });
    },
  },
};
</script>

<style>
.new-deck-form {
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

.name-div-add-deck {
  grid-area: name;
}

.name-add-deck {
  padding: 10px 50px 10px 50px;
  border-radius: 5px;
  box-shadow: 5px 5px 5px #c7e1f1;
}

.subject-div-add-deck {
  grid-area: subject;
}

.subject-add-deck {
  padding: 10px 50px 10px 50px;
  border-radius: 5px;
  box-shadow: 5px 5px 5px #c7e1f1;
}

.desc-add-deck {
  padding: 10px 50px 10px 50px;
  border-radius: 5px;
  box-shadow: 5px 5px 5px #c7e1f1;
  resize: none;
  text-align: center;
}

.desc-div-add-deck {
  grid-area: desc;
  margin-top: 20px;
}

.add-deck-buttons {
  grid-area: button;
  display: flex;
  justify-content: space-around;
}

.save-add-deck {
  border-radius: 10px;
  width: 125px;
  height: 50px;
  margin: 10px;
  margin-left: 300px;
  padding: 10px;
  font-weight: 700;
}

.cancel-add-deck {
  border-radius: 10px;
  width: 125px;
  height: 50px;
  margin: 10px;
  margin-right: 300px;
  padding: 10px;
  font-weight: 700;
}

.ndbutton {
  width: 150px;
  margin: 5px auto;

  border-radius: 5px;
}
</style>