<template>
  <div>
    <div class="main-container">
      <h1>Welcome to Flashdex!</h1>
      <h3>Improving your brain one flashcard at a time!</h3>
      <p>
        Check out these example cards! The answers can be viewed by pressing
        'Flip'.
      </p>
     
    </div>
    <hr />
    <div id="filter-bar">
      <label for="filter-cards">Search By Tags: </label>
      <br />
      <input
        class="filter-bar"
        type="text"
        name="filter-cards"
        v-model="filter"
      />
    </div>
     <div id="default-session"><button id="ssbutton">Try a study session</button></div>
    <div class="example-container">
      <card
        v-for="card in filteredCards"
        v-bind:key="card.cardId"
        v-bind:card="card"
      />
    </div>
    
    
  </div>
</template>

<script>
import Card from "../components/Card.vue";
export default {
  components: { Card },
  name: "default-home",
   data() {
    return {
      cards: [],
      filter: "",
    };
  },
  created() {
    this.cards = this.$store.state.exampleCards;
  },
  computed: {
    filteredCards() {
      return this.cards.filter((card) => {
        return card.tags.toLowerCase().includes(this.filter.toLowerCase());
      });
    },
  },

};
</script>

<style>
.example-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  
}

.main-container {
  text-align: center;
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
  ;
}
#study-session{
  margin:auto;
}
#ssbutton{
  
  border-radius: 10px;
  width: 175px;
  height: 50px;
  align-items:center;
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
  background-color: #deebf3;
  border-radius: 10px;
  font-size: 20px;
  font-weight: bold;
  
  
}
#default-session{
  display: flex;
  justify-content: space-around;
  margin-top:10px;
}
</style>