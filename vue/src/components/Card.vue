<template>
  <div>
    <div id="front" v-show="showFront">
      <h1 class="subject">{{ card.subject }}</h1>
      <p class="tags">{{ card.tags }}</p>
      <h3 class="question">{{ card.question }}</h3>
      <button class="edit">Edit</button>
      <p class="author">{{ this.username }}</p>
      <button class="flip">Flip</button>
    </div>
    <div id="back" v-show="!showFront">
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
</style>