<template> 
    <div class="parent-dashboard">
    <h1 id="title">Parent Dashboard</h1>
    <h3 id="subtext">Keep track of your kid's reading. Build habits for life.</h3>
      <table class="Children List">
      <label for="Children">Children **TABLE OF CHILDREN ACCOUNTS**</label>
        <tr>
          <th>Name</th>
          <th>Books Finished</th>
          <th>Hours Read</th>
          <th>Last Active?</th>
        </tr>
        <tr v-for="user in familyUsers" :key="user.id">
          <td>{{user.first_name}}</td>
          <td>5</td>
          <td>30</td>
          <td>4/14/2022</td>
        </tr>
      </table> 

    <button class="btn" type="submit" @click="goToRegisterChild">
        Create | Edit Child Account
      </button>
    <button class="btn" type="submit">
        Create | Edit Parent Account
      </button>

  </div>
</template>

<script>
import AuthService from "@/services/AuthService";

export default {
// create + data (empty group of users that I will fill with this return request)
  name: 'parent-dashboard-userID',          // Spot check this with the team. 
  // Reg Note:  If I need to do a PROP, it's here
  data() {
    return {
      user: {         // Spot check this with the team.  
        id: '',              
      },
      familyUsers: [],
      // currentUserId: this.$route.params.userId

    }
  },
    computed: {
    currentUserId: function(){
      return this.$store.state.user.id
    }
  },
  methods: {
    goToRegisterChild(){
      this.$router.push({name: 'register-child'})
    }
  },

created() {
    AuthService
      .getFamilyByUserId(this.currentUserId)
      .then(response => {
          this.familyUsers = response.data;
      })
  }
}

</script>

<style>

</style>