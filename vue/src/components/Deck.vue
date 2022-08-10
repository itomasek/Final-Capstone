<template>
  <div>
      <div id="deck-container">
          <h1 class="deck-name">{{deck.name}}</h1>
          <h4 class="deck-subject">{{deck.subject}}</h4>
          <br>
          <p class="deck-description">{{deck.description}}</p>
          
      </div>

  </div>
</template>

<script>
export default {
    name: "deck",
    props: ["deck"],
    computed: {
    username() {
      return this.$store.state.user.username;
    },
  },
}
</script>

<style>

</style>