<template>
  <div>
    <h1>New Card Form</h1>
    <form class="new-card-form">
      <div class="sub-div">
        <label for="subject">Card Subject: </label>
        <br />
        <input
          class="subject-add-card"
          type="text"
          name="subject"
          v-model="card.subject"
          placeholder="What is this card about?"
        />
      </div>
      <div class="q-div">
        <label for="question">Card Question: </label>
        <br />
        <textarea
          class="question-add-card"
          name="question"
          cols="30"
          rows="10"
          v-model="card.question"
          placeholder="Question You Would Like To Study:"
        ></textarea>
      </div>
      <div class="tag-div">
        <label for="tags">Tags: </label>
        <br />
        <input class="tags-add-card" name="tags" type="text" v-model="card.tags" placeholder="Make Your Card Searchable!" />
      </div>
      <div class="a-div">
        <label for="answer">Card Answer: </label>
        <br />
        <textarea
          class="answer-add-card"
          name="answer"
          cols="30"
          rows="10"
          v-model="card.answer"
          placeholder="The Answer To Your Question:"
        ></textarea>
      </div>
      <div class="button-div">
        <button class="save-button" type="submit" v-on:click.prevent="saveCard">
          Save New Card
        </button>
        <button class="cancel-button" v-on:click="cancelForm">Cancel</button>
      </div>
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
      this.$store.commit("CLEAR_EDIT_CARD");
      this.$router.push({ name: "home" });
    },
  },
};
</script>

<style>
h1 {
  color: black;
  font-weight: bolder;
}
.new-card-form {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-areas:
    ". subject tags ."
    ". question answer . "
    ". button button .";
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
  text-align: center;
}

.sub-div {
  grid-area: subject;
  margin-left: 45px;
}

.tag-div {
  grid-area: tags;
}

.q-div {
  grid-area: question;
  margin-left: 45px;
  margin-top: 20px;
}

.a-div {
  grid-area: answer;
  margin-top: 20px;
}

.button-div {
  grid-area: button;
  display: flex;
  justify-content: space-around;
}

.save-button {
  border-radius: 10px;
  width: 125px;
  height: 50px;
  margin: 10px;
  margin-left: 300px;
  padding: 10px;
  font-weight: 700;
}

.cancel-button {
  border-radius: 10px;
  width: 125px;
  height: 50px;
  margin: 10px;
  margin-right: 300px;
  padding: 10px;
  font-weight: 700;
}

.subject-add-card {
  padding: 10px 50px 10px 50px;
  border-radius: 5px;
  box-shadow: 5px 5px 5px #c7e1f1;
}

.question-add-card {
  padding: 10px 50px 10px 50px;
  border-radius: 5px;
  box-shadow: 5px 5px 5px #c7e1f1;
  resize: none;
  
}

.tags-add-card {
  padding: 10px 50px 10px 50px;
  border-radius: 5px;
  box-shadow: 5px 5px 5px #c7e1f1;
}

.answer-add-card {
  padding: 10px 50px 10px 50px;
  border-radius: 5px;
  box-shadow: 5px 5px 5px #c7e1f1;
  resize: none;
}
</style>