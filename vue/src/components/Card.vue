<template>
  <div>
    <div id="front" v-if="showFront">
      <h3 class="subject">{{ card.subject }}</h3>
      <p class="tags">{{ card.tags }}</p>
      <h2 class="question">Question: {{ card.question }}</h2>
      <button class="edit" v-on:click="editCard">Edit</button>
      <p class="author">{{ this.username }}</p>
      <button class="flip" v-on:click="showFront = !showFront">Flip</button>
    </div>
    <div id="back" v-else>
      <h3 class="subject">{{ card.subject }}</h3>
      <p class="tags">{{ card.tags }}</p>
      <h2 class="answer">Answer: {{ card.answer }}</h2>
      <button class="edit" v-on:click="editCard">Edit</button>
      <p class="author">{{ this.username }}</p>
      <button class="flip" v-on:click="showFront = !showFront">Flip</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "card",
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
    editCard() {
      this.$store.commit("SET_EDIT_CARD", this.card);
      this.$router.push({
        name: "card-detail",
        params: { card_id: this.card.cardId },
      });
    },
  },
};
</script>

<style>
#front {
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas:
    "subject . tags "
    "question question question"
    "edit author flip";
  border: solid black 2px;
  padding: 50px;
  margin: 50px;
  border-radius: 30px;
  background-color: #8ab4a7;
  width: 400px;
  height: 300px;
}

#back {
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-rows: 1fr 1fr 1fr;
  grid-template-areas:
    "subject . tags "
    "answer answer answer"
    "edit author flip";
  border: solid black 2px;
  padding: 50px;
  margin: 50px;
  border-radius: 30px;
  background-color: #dbf0e9;
  width: 400px;
  height: 300px;
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

.edit {
  grid-area: edit;
  border-radius: 10px;
  width: 75px;
  height: 50px;
}

.author {
  grid-area: author;
  text-align: justify;
}

.flip {
  grid-area: flip;
  border-radius: 10px;
  width: 75px;
  height: 50px;
}

.answer {
  grid-area: answer;
}
</style>