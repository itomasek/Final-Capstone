<template>
  <div>
    <div id="front" v-if="showFront">
      <h1 class="subject">{{ card.subject }}</h1>
      <p class="tags">{{ card.tags }}</p>
      <h3 class="question">Question: <br>{{ card.question }}</h3>
      <button class="edit" v-on:click="editCard">Edit</button>
      <p class="author">{{ this.username }}</p>
      <button class="flip" v-on:click="showFront = !showFront">Flip</button>
      
    </div>
    <div id="back" v-else>
      <h1 class="subject">{{ card.subject }}</h1>
      <p class="tags">{{ card.tags }}</p>
      <h3 class="answer">Answer: <br>{{ card.answer }}</h3>
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
      this.$store.commit('SET_EDIT_CARD', this.card);
      this.$router.push({name: 'card-detail', params: {card_id: this.card.cardId}});
    }
  },
};
</script>

<style>
#front {
  font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
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
  background-color: #C9E3DA;
  width: 400px;
}

#back {
  font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas:
    "subject . tags "
    "answer answer answer"
    "edit author flip";
  border: solid black 2px;
  padding: 50px;
  margin: 50px;
  border-radius: 30px;
  background-color: #DBF0E9;
  width: 400px;
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

.edit {
  grid-area: edit;
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