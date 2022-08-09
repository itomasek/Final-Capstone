<template>

  <div class="container">
      <div>
          logo place holder
      </div>
      <div> 
          <router-link v-bind:to="{name: 'home'}"><button>Home</button></router-link>
        </div>
      
      <div v-if="$store.state.token != ''">
          <router-link v-bind:to="{name: 'logout'}"><button>Logout</button></router-link>
        </div>
      <div>
          <router-link v-bind:to="{name: 'register'}"><button>Register</button></router-link>
        </div>
      <div><button>Info</button></div>
  </div>
</template>

<script>
export default {
    name: "app-header"
}
</script>

<style>
.container {
    display: flex;
    justify-content: space-evenly;
    flex-wrap: nowrap;
    background: blanchedalmond;
    padding: 5px;
    margin: 5px;
}

</style>