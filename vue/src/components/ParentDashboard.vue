<template> 
    <div class="parent-dashboard">
      <div class="title">
        <h1>Parent Dashboard<span>Keep track of your kid's reading. Build habits for life.</span></h1>
      </div>
      <table class="parent">
      <label for="Children"></label>
        <tr>
          <th>Child</th>
          <th>Number of Books Completed</th>
          <th>Minutes Read</th>
          <th>Current Book</th>
          <th>Points Balance</th>
        </tr>
        <tr v-for="user in familyUsers" :key="user.id">
          <td>{{user.first_name}}</td>
          <td>{{}}</td>
          <td>{{}}</td>
          <td>{{}}</td>
          <td>{{}}</td>
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
.parent {
  margin-left: auto;
  margin-right: auto;
  width: 100%;
  justify-content: center;
}
.parent td, .parent th {
  border: 1px solid #bbf2fc;
  padding: 8px;
}
.parent tr:nth-child(even){background-color: #f2f2f2;}

.parent tr:hover {background-color: #ddd;}

.parent th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #126c7c;
  color: white;
}

</style>