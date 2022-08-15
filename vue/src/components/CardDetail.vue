<template>
  <div>
    <h1>Edit Your Card</h1>
    <form class="edit-card-form">
      <div class="sub-div-edit-card">
        <label for="subject">Card Subject: </label>
        <br />
        <input
          class="subject-edit-card"
          type="text"
          name="subject"
          v-model.trim="card.subject"
        />
      </div>
      <div class="q-div-edit-card">
        <label for="question">Card Question: </label>
        <br />
        <textarea
          class="question-edit-card"
          name="question"
          cols="30"
          rows="10"
          v-model.trim="card.question"
        ></textarea>
      </div>
      <div class="tag-div-edit-card">
        <label for="tags">Tags: </label>
        <br />
        <input
          class="tags-edit-card"
          name="tags"
          type="text"
          v-model.trim="card.tags"
        />
      </div>
      <div class="a-div-edit-card">
        <label for="answer">Card Answer: </label>
        <br />
        <textarea
          class="answer-edit-card"
          name="answer"
          cols="30"
          rows="10"
          v-model.trim="card.answer"
        ></textarea>
      </div>
      <div class="edit-card-button-div">
        <button class="save-button-edit-card" v-on:click.prevent="saveEdit">
          Save Your Changes
        </button>
        <button class="delete-button-edit-card" v-on:click="deleteCard">
          Delete This Card
        </button>
        <button class="cancel-button-edit-card" v-on:click="cancelEdit">
          Cancel
        </button>
      </div>
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
    deleteCard() {
      CardService.deleteCardsFromDeck(this.card.cardId);
      CardService.deleteCard(this.card.cardId);
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
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
}

.edit-card-form {
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

.sub-div-edit-card {
  grid-area: subject;
  margin-left: 45px;
}

.tag-div-edit-card {
  grid-area: tags;
}

.q-div-edit-card {
  grid-area: question;
  margin-left: 45px;
  margin-top: 20px;
}

.a-div-edit-card {
  grid-area: answer;
  margin-top: 20px;
}

.edit-card-button-div {
  grid-area: button;
  display: flex;
  justify-content: space-around;
}

.subject-edit-card {
  padding: 10px 50px 10px 50px;
  border-radius: 5px;
  box-shadow: 5px 5px 5px #c7e1f1;
}

.question-edit-card {
  padding: 10px 50px 10px 50px;
  border-radius: 5px;
  box-shadow: 5px 5px 5px #c7e1f1;
  resize: none;
}

.tags-edit-card {
  padding: 10px 50px 10px 50px;
  border-radius: 5px;
  box-shadow: 5px 5px 5px #c7e1f1;
}

.answer-edit-card {
  padding: 10px 50px 10px 50px;
  border-radius: 5px;
  box-shadow: 5px 5px 5px #c7e1f1;
  resize: none;
}

.edit-card-button-div {
  grid-area: button;
  display: flex;
  justify-content: space-around;
  margin-top: 20px;
}

.save-button-edit-card {
  border-radius: 10px;
  width: 125px;
  height: 50px;
  margin: 10px;

  padding: 10px;
  font-weight: 700;
}

.delete-button-edit-card {
  border-radius: 10px;
  width: 125px;
  height: 50px;
  margin: 10px;

  padding: 10px;
  font-weight: 700;
}

.cancel-button-edit-card {
  border-radius: 10px;
  width: 125px;
  height: 50px;
  margin: 10px;

  padding: 10px;
  font-weight: 700;
}

textarea {
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
}
</style>