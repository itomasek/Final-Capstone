<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <router-link :to="{name: 'new-card'}">Create A New Card</router-link>
    <br>
    <router-link :to="{name: 'my-cards', params: {user_id: this.$store.state.user.id}}">View Your Cards</router-link>
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>
