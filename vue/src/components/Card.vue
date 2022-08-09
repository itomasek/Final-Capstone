<template>
  <div>
    <div id="front" >
      <h1 class="subject">{{ card.subject }}</h1>
      <p class="tags">{{ card.tags }}</p>
      <h3 class="question">{{ card.question }}</h3>
      <button class="edit">Edit</button>
      <p class="author">{{ this.username }}</p>
      <button class="flip">Flip</button>
    </div>
    <div id="back" >
      <h1 class="subject">{{ card.subject }}</h1>
      <p class="tags">{{ card.tags }}</p>
      <h3 class="answer">{{ card.answer }}</h3>
      <button class="edit">Edit</button>
      <p class="author">{{ this.username }}</p>
      <button class="flip">Flip</button>
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
    data() {
      return {
        showFront: true,
      };
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
      "edit author flip" ;
  border: solid black 2px;
  padding: 50px;
  margin: 50px;
}

#back {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas: 
      "subject . tags "
      "answer answer answer"
      "edit author flip" ;
  border: solid black 2px;
  padding: 50px;
  margin: 50px;
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