<template>
  <div>
    <div id="front" v-if="showFront">
      <h1 class="subject">{{ card.subject }}</h1>
      <p class="tags">{{ card.tags }}</p>
      <h3 class="question">Question: <br />{{ card.question }}</h3>
      <div class="add-to-deck">
        <label for="AddToDeck">Add To Deck</label>
        <input
          type="checkbox"
          name="AddToDeck"
          v-bind:id="card.cardId"
          v-bind:value="card.cardId"
          v-on:change="toggleDeckArray(card.cardId)"
        />
      </div>
      <p class="author">{{ this.username }}</p>
      <button class="flip" v-on:click="showFront = !showFront">Flip</button>
    </div>
    <div id="back" v-else>
      <h1 class="subject">{{ card.subject }}</h1>
      <p class="tags">{{ card.tags }}</p>
      <h3 class="answer">Answer: <br />{{ card.answer }}</h3>
      <div class="add-to-deck">
        <label for="AddToDeck">Add To Deck</label>
        <input
          type="checkbox"
          name="AddToDeck"
          v-bind:id="card.cardId"
          v-bind:value="card.cardId"
          v-on:change="toggleDeckArray(card.cardId)"
        />
      </div>
      <p class="author">{{ this.username }}</p>
      <button class="flip" v-on:click="showFront = !showFront">Flip</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "deck-card",
  props: ["card"],
  computed: {
    username() {
      return this.$store.state.user.username;
    },
  },
  data() {
    return {
      showFront: true,
    };
  },

  methods: {
    toggle() {
      !this.showFront;
    },
    toggleDeckArray(cardId) {
      if (this.$store.state.cardIdsToAdd.includes(cardId)) {
        this.$store.commit("REMOVE_CARD_ID", cardId);
      } else {
        this.$store.commit("ADD_CARD_ID", cardId);
      }
    },
  },
};
</script>

<style scoped>
#front {
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas:
    "subject . tags "
    "question question question"
    "add author flip";
  border: solid black 2px;
  padding: 50px;
  margin: 50px;
  border-radius: 30px;
  background-color: #c9e3da;
  width: 300px;
}

#back {
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas:
    "subject . tags "
    "answer answer answer"
    "add author flip";
  border: solid black 2px;
  padding: 50px;
  margin: 50px;
  border-radius: 30px;
  background-color: #dbf0e9;
  width: 300px;
}

.subject {
  grid-area: subject;
  text-decoration: underline;
}

.tags {
  grid-area: tags;
}

.question {
  grid-area: question;
}

.add-to-deck {
  grid-area: add;
  margin-top: 50px;
  font-weight: 600;
}

.author {
  grid-area: author;
  text-align: center;
}

.flip {
  grid-area: flip;
}

.answer {
  grid-area: answer;
}
</style>