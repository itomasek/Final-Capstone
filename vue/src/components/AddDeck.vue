<template>
  <div>
    <form class="new-deck-form" v-on:submit.prevent>
      <h1>New Deck Form</h1>
      <div>
        <label for="name">Deck Name: </label>
        <br />
        <input type="text" name="name" v-model="deck.name" />
      </div>
      <div>
        <label for="subject">Deck Subject: </label>
        <br />
        <input type="text" name="subject" v-model="deck.subject" />
      </div>
      <div>
        <label for="description">Deck Description</label>
        <br />
        <textarea
          name="description"
          cols="30"
          rows="10"
          v-model="deck.description"
        ></textarea>
      </div>
      <button type="submit" v-on:click.prevent="saveDeck">Save New Deck</button>
      <button v-on:click="cancelForm">Cancel</button>
    </form>
  </div>
</template>

<script>
import CardService from "../services/CardService";
export default {
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
  margin-left: 300px;
  display: flex;
  flex-direction: column;
  align-content: center;
}
</style>