<template>
  <div>
    <form class="new-card-form">
      <h1>Edit Card</h1>
      <div>
        <label for="subject">Card Subject: </label>
        <br />
        <input type="text" name="subject" v-model.trim="card.subject" />
      </div>
      <div>
        <label for="question">Card Question: </label>
        <br />
        <textarea 
          name="question"
          cols="30"
          rows="10"
          v-model.trim="card.question"
        ></textarea>
      </div>
      <div>
        <label for="tags">Tags: </label>
        <br />
        <input name="tags" type="text" v-model.trim="card.tags" />
      </div>
      <div>
        <label for="answer">Card Answer: </label>
        <br />
        <textarea
          name="answer"
          cols="30"
          rows="10"
          v-model.trim="card.answer"
        ></textarea>
      </div>
      <button class="editcard" v-on:click.prevent="saveEdit">Save Your Changes</button>
      
      <button class="editcard" v-on:click="cancelEdit">Cancel</button>
    </form>
  </div>
</template>

<script>
import CardService from "../services/CardService.js";

export default {
  name: "card-detail",
  data() {
    return {
      card: {
        cardId: null,
        subject: "",
        question: "",
        tags: "",
        answer: "",
        userId: "",
      },
    };
  },
  created() {
    this.card = this.$store.state.activeEditCard;
  },
  methods: {
    cancelEdit() {
      this.$router.push({
        name: "my-cards",
        params: { user_id: this.card.userId },
      });
    },
    saveEdit() {
      CardService.updateCard(this.card.cardId, this.card);
      this.$router.push({
        name: "my-cards",
        params: { user_id: this.card.userId },
      });
    },
  },
};
</script>

<style>
.h1 {
  font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
}

.editcard {
  margin: 5px auto;
  width: 150px;
  background-color: #deebf3;
  border-radius: 5px;
}
textarea{
  font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
}
</style>