<template>
  <div id="sidebar-container" v-if="$store.state.token != ''">
      <div>
          <router-link v-bind:to="{name: 'new-card'}"><button>Create New Card</button></router-link>
      </div>
      <div>
        <router-link v-bind:to="{name: 'new-deck'}"><button>Create New Deck</button></router-link>
      </div>
    <div>
      <router-link v-bind:to="{ name: 'my-cards', params: {user_id: this.$store.state.user.id} }">
        <button>Your Cards</button>
      </router-link>
    </div>
    <div><router-link v-bind:to="{name: 'my-decks', params: {user_id: this.$store.state.user.id}}"><button>Your Decks</button></router-link></div>
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
        background-color: #CDDEE8;
    }

    #sidebar-container button {
        padding: 50px 25px 50px 25px;
        background-color: #DEEBF3;
        color: black;
        font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
        width: 205px;
    }
    
    #sidebar-container button:hover{
      text-decoration: underline;
      color: black;
    }
    
</style>