<template>
    <div class="parent-dashboard">
    <h1 id="title">Parent Dashboard</h1>
    <h3 id="subtext">Keep track of your kid's reading. Build habits for life.</h3>
      <table class="Children List">
      <label for="Children">Children **TABLE OF CHILDREN ACCOUNTS**</label>
        <!-- <tr>
          <th>Name</th>
          <th>Books Finished</th>
          <th>Hours Read</th>
          <th>Last Active?</th>
        </tr>-->
      </table> 

    <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create | Edit Child Account
      </button>
    <button class="btn btn-lg btn-primary btn-block" type="submit">
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
    }
  },

//  Review this with team
created() {
    AuthService
      .create(this.user)
      .then(response => {
        if (response.status === 201) {
          this.$router.push({name: 'home'});  // Note: This might be '/' instead
        }
      })
  }
}

</script>

<style>

</style>