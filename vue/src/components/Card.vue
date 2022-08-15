<template>
  <div>
    <div id="front-card" v-if="showFront">
      <h3 class="subject">{{ card.subject }}</h3>
      <p class="tags">{{ card.tags }}</p>
      <h2 class="question">Question: {{ card.question }}</h2>
      <button class="edit"  v-show="showEdit" v-on:click="editCard">Edit</button>
      <p class="author">{{ this.username }}</p>
      <button class="flip" v-on:click="showFront = !showFront">Flip</button>
    </div>
    <div id="back-card" v-else>
      <h3 class="subject">{{ card.subject }}</h3>
      <p class="tags">{{ card.tags }}</p>
      <h2 class="answer">Answer: {{ card.answer }}</h2>
      <button class="edit"  v-show="showEdit" v-on:click="editCard">Edit</button>
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
    showEdit() {
      return (this.card.cardId < 500 && (this.$store.state.studySession == false)) ? true : false;
    }
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
#front-card {
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
  
  width: 400px;
  height: 300px;
  background-image: url("../../assets/Question.png");
  background-repeat: no-repeat;
  background-size: cover;
  font-weight: bold;
  background-blend-mode: color-burn;
 
}

#back-card {
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
  width: 400px;
  height: 300px;
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
  font-weight: 700;
}

.answer {
  grid-area: answer;
}
</style>