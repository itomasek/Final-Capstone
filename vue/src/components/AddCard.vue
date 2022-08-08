<template>
  <div>
    <form v-on:submit.prevent>
      <div>
          <label for="subject">Card Subject: </label> 
          <input type="text" name="subject" v-model="card.subject"/>
      </div>
      <div>
          <label for="question">Card Question: </label> 
          <textarea name="question" cols="30" rows="10" v-model="card.question"></textarea>
      </div>
      <div>
          <label for="answer">Card Answer: </label> 
          <textarea name="answer" cols="30" rows="10" v-model="card.answer"></textarea>
      </div>
      <button type="submit" v-on:click.prevent="saveCard">Save New Card</button>
      <button  v-on:click="cancelForm"> Cancel </button>
    </form>
  </div>
</template>

<script>
export default {
  name: "add-card",
  props: [],
  data() {
    return {
      card: {
        card_id: null,
        subject: "",
        question: "",
        tags: [],
        answer: "",
        favorited: false,
        user_id: this.$store.state.user.id,
      },
    };
  },
  methods: {
      saveCard() {

      },
      cancelForm() {
          this.$router.push({name: 'home'});
      }
  }
};
</script>

<style>
</style>