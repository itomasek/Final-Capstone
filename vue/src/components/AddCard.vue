<template>
  <div>
    <form class="new-card-form" v-on:submit.prevent>
      <h1>New Card Form</h1>
      <div>
        <label for="subject">Card Subject: </label>
        <br />
        <input type="text" name="subject" v-model="card.subject" />
      </div>
      <div>
        <label for="question">Card Question: </label>
        <br />
        <textarea
          name="question"
          cols="30"
          rows="10"
          v-model="card.question"
        ></textarea>
      </div>
      <div>
        <label for="tags">Tags: </label>
        <br />
        <input name="tags" type="text" v-model="card.tags" />
      </div>
      <div>
        <label for="answer">Card Answer: </label>
        <br />
        <textarea
          name="answer"
          cols="30"
          rows="10"
          v-model="card.answer"
        ></textarea>
      </div>
      <button class="ncbutton" type="submit" v-on:click.prevent="saveCard">Save New Card</button>
      <button class="ncbutton" v-on:click="cancelForm">Cancel</button>
    </form>
  </div>
</template>

<script>
import CardService from "../services/CardService.js";

export default {
  name: "add-card",
  props: [],
  data() {
    return {
      card: {
        cardId: null,
        subject: "",
        question: "",
        tags: "",
        answer: "",
        userId: this.$store.state.user.id,
      },
    };
  },
  methods: {
    saveCard() {
      CardService.create(this.card).then((response) => {
        if (response.status == 200) {
          this.card = {
            cardId: null,
            subject: "",
            question: "",
            tags: "",
            answer: "",
            userId: this.$store.state.user.id,
          };
          this.$router.push({
            name: "my-cards",
            params: { user_id: this.card.userId },
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
.new-card-form {
  
  display: flex;
  flex-direction: column;
  align-content: center;
  font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
  text-align: center;
}

.ncbutton {
  margin-bottom: 5px;
  width: 150px;
  margin:auto;

}
</style>