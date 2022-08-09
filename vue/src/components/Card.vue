<template>
  <div>
    <div id="front" v-if="showFront">
      <h1 class="subject">{{ card.subject }}</h1>
      <p class="tags">{{ card.tags }}</p>
      <h3 class="question">Question: <br>{{ card.question }}</h3>
      <button class="edit">Edit</button>
      <p class="author">{{ this.username }}</p>
      <button class="flip" v-on:click="showFront = !showFront">Flip</button>
    </div>
    <div id="back" v-else>
      <h1 class="subject">{{ card.subject }}</h1>
      <p class="tags">{{ card.tags }}</p>
      <h3 class="answer">Answer: <br>{{ card.answer }}</h3>
      <button class="edit">Edit</button>
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
  },
};
</script>

<style>
#front {
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
  background-color: burlywood;
}

#back {
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
  background-color: burlywood;
}

h1 {
  text-decoration: underline;
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
}

.author {
  grid-area: author;
}

.flip {
  grid-area: flip;
}

.answer {
  grid-area: answer;
}
</style>