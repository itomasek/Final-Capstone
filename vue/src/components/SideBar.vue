<template>
  <div id="sidebar-container" v-if="$store.state.token != ''">
      <div>
          <router-link v-bind:to="{name: 'new-card'}"><button>Create New Card</button></router-link>
      </div>
    <div>
      <router-link v-bind:to="{ name: 'my-cards', params: {user_id: this.$store.state.user.id} }">
        <button>Your Cards</button>
      </router-link>
    </div>
    <div><button>Your Decks</button></div>
    <div><button>Study Session</button></div>
  </div>
</template>

<script>
export default {
  name: "side-bar",
};
</script>

<style>
    #sidebar-container {
        display: flex;
        flex-direction: column;
        flex-wrap: nowrap;
        height: 100vh;
        margin-bottom: 100px;
        position: absolute;
        justify-content: space-around;
        background-color: rgb(177, 87, 219);
    }

    #sidebar-container button {
        padding: 50px;
        background-color: aquamarine;
        color: brown;
    }
</style>