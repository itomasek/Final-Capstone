<template>
  <div>
    <div id="front" v-if="showFront">
      <h3 class="subject">{{ card.subject }}</h3>
      <p class="tags">{{ card.tags }}</p>
      <h2 class="question">Question: {{ card.question }}</h2>
      <div class="add-to-deck">
        <label for="AddToDeck"> {{ determineCheckText }} </label>
        <input
          type="checkbox"
          name="AddToDeck"
          v-bind:id="card.cardId"
          v-bind:value="card.cardId"
          v-on:change="toggleDeckArray(card.cardId)"
          v-model="idInStore"
        />
      </div>
      <p class="author">{{ this.username }}</p>
      <button class="flip" v-on:click="showFront = !showFront">Flip</button>
    </div>
    <div id="back" v-else>
      <h1 class="subject">{{ card.subject }}</h1>
      <p class="tags">{{ card.tags }}</p>
      <h3 class="answer">Answer: {{ card.answer }}</h3>

      <p class="author">{{ this.username }}</p>
      <button class="flip" v-on:click="showFront = !showFront">Flip</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "deck-card",
  props: ["card", "isActive"],
  computed: {
    username() {
      return this.$store.state.user.username;
    },
    determineCheckText() {
      return this.$store.state.cardIdsToAdd.includes(this.card.cardId)
        ? "Card Is In Deck"
        : "Add Card To Deck";
    },
  },
  data() {
    return {
      showFront: true,
      currentIds: [],
      idInStore: null
    };
  },
  created() {
    this.currentIds = this.$store.state.cardIdsToAdd;
      if (this.$store.state.cardIdsToAdd.includes(this.card.cardId)) {
        this.idInStore = true;
      } else {
        this.idInStore = false;
      }
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
  grid-template-rows: 1fr 1fr 1fr;
  grid-template-areas:
    "subject . tags "
    "question question question"
    "add author flip";
  border: solid black 2px;
  padding: 50px;
  margin: 50px;
  border-radius: 30px;
  height: 300px;
  width: 300px;
  background-image: url("../../assets/Question.png");
  background-repeat: no-repeat;
  background-size: cover;
  font-weight: bold;
  background-blend-mode: color-burn;
}

#back {
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas:
    "subject . tags "
    "answer answer answer"
    ". author flip";
  border: solid black 2px;
  padding: 50px;
  margin: 50px;
  border-radius: 30px;
  
  width: 300px;
  background-image: url('../../assets/check-mark.png');
  background-size: cover;
  background-repeat: no-repeat;
  background-blend-mode:multiply;
}

.subject {
  grid-area: subject;
  
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
  margin-top: 50px;
}

.flip {
  grid-area: flip;
  margin-top: 50px;
  margin-left: 10px;
}

.answer {
  grid-area: answer;
}
</style>