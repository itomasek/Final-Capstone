<template>
  <div class="study-session-content">
    <div v-if="totalAnswers == studyCards.length">
      <h3 class="session-headline">Session Complete! Here are your results:</h3>
      <h2 class="correct-count">
        {{ correctCount }} / {{ totalCards }} Cards Marked Correct
      </h2>

      <h2 class="incorrect-count">
        {{ incorrectCount }} / {{ totalCards }} Cards Marked Incorrect
      </h2>
      <div class="complete-buttons">
        <button class="RES-button" v-on:click="reset">
          Restart This Session</button
        ><button class="RES-button" v-on:click="exit">Exit Study Session</button
        ><button class="RES-button" v-on:click="saveResults" v-show="$store.state.token != ''">Save These Results</button>
      </div>
    </div>
    <div class="main-container" v-show="totalAnswers < studyCards.length">
      <h3>Card {{ counterControl + 1 }} / {{ totalCards }}</h3>

      <div class="card-container">
        <card
          v-for="card in studyCards"
          v-bind:key="card.cardId"
          v-bind:card="card"
          v-show="counterControl == studyCards.indexOf(card)"
        />
      </div>
      <div class="controls">
        <button class="mark-incorrect" v-on:click="incorrect">
          Mark Incorrect</button
        ><button class="mark-correct" v-on:click="correct">Mark Correct</button>
      </div>
    </div>
    <div class="session-totals" v-if="totalAnswers < studyCards.length">
      <h2 class="correct-count">
        {{ correctCount }} / {{ totalCards }} Cards Marked Correct
      </h2>

      <h2 class="incorrect-count">
        {{ incorrectCount }} / {{ totalCards }} Cards Marked Incorrect
      </h2>

      <button class="RES-button" v-on:click="exit">End Study Session</button>

      <button class="RES-button" v-on:click="reset">
        Restart Study Session
      </button>
    </div>
  </div>
</template>

<script>
import Card from "../components/Card.vue";
import CardService from "../services/CardService";
export default {
  components: { Card },
  name: "study-session",
  data() {
    return {
      studyCards: [],
      counterControl: 0,
      correctCount: 0,
      incorrectCount: 0,
    };
  },
  created() {
    this.$store.commit('TOGGLE_SESSION');
    if (this.$store.state.token == "") {
      this.studyCards = this.$store.state.exampleCards;
    } else {
      CardService.getCardsByDeckId(this.$store.state.activeDeck).then(
        (response) => {
          this.studyCards = response.data;
        }
      );
    }
  },
  destroyed() {
    this.$store.commit('TOGGLE_SESSION')
  },
  computed: {
    totalCards() {
      return this.studyCards.length;
    },
    totalAnswers() {
      return this.correctCount + this.incorrectCount;
    },
    session() {
      return {
        sessionId: null,
        deckStudied: this.$store.state.activeDeckName,
        totalCards: this.totalCards,
        totalCorrect: this.correctCount,
        totalIncorrect: this.incorrectCount,
        userId: this.$store.state.user.id,
      };
    },
  },
  methods: {
    reset() {
      this.counterControl = 0;
      this.correctCount = 0;
      this.incorrectCount = 0;
    },
    exit() {
      this.$router.push("/");
    },
    correct() {
      this.counterControl++;
      this.correctCount++;
    },
    incorrect() {
      this.counterControl++;
      this.incorrectCount++;
    },
    saveResults() {
      CardService.saveSession(this.session);
      this.$store.commit('CLEAR_ACTIVE_DECK');
      this.$store.commit('CLEAR_DECK_NAME');
      this.$router.push({name: 'session-summary'});
    }
  },
};
</script>

<style>
.main-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  grid-area: session;
}

.mark-incorrect {
  border-radius: 10px;
  width: 100px;
  height: 65px;
  margin: 10px;
  padding: 10px;
  font-weight: 700;
  background-color: rgb(236, 111, 111);
  box-shadow: rosybrown;
}
.mark-correct {
  border-radius: 10px;
  width: 100px;
  height: 65px;
  margin: 10px;
  padding: 10px;
  font-weight: 700;
  background-color: rgb(37, 243, 127);
  box-shadow: rosybrown;
}

.RES-button {
  border-radius: 10px;
  width: 125px;
  height: 50px;
  margin: 10px;
  padding: 10px;
  font-weight: 700;
}

.session-totals {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-around;
  grid-area: totals;
}

.study-session-content {
  display: grid;
  grid-template-columns: 2fr 1fr;
  grid-template-areas: "session totals";
}

.correct-count {
  color: green;
}

.incorrect-count {
  color: red;
}

.complete-buttons {
  display: flex;
  justify-content: space-around;
}

.session-headline {
  text-align: center;
}
</style>