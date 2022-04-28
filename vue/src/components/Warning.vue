<template>
  <div class='warning' >
    <h2 id='warning-header'>DEMO MODE</h2>
    <p id='warning-pipe'>|</p>
    <p id='warning-message'>Please login with username: <em>user</em> and password: <em>password</em></p> 
    <p id='warning-pipe'>|</p>
    <p id='warning-message-server'><b>Warning:</b> Server has a sleep timer, wait 30 seconds after first opening for full operation</p>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>

.warning {
    display: flex;
    background-color: rgb(143, 81, 81);
    color: rgb(221, 221, 221);
    box-shadow: 0 4px 4px 0 rgba(0,0,0,0.10),0 5px 5px 0 rgba(0,0,0,0.08);box-shadow: 4px rgba(0,0,0,0.10),4px rgba(0,0,0,0.08);
    border-radius: 10px; 
    margin: 0;
    padding: 0 .5em;
    justify-content: space-between;
    align-items: center;
}
#warning-header {
    margin: 0.2em 0.5em;
    align-content: center;
    vertical-align: middle;
    padding-top: 0.1em;

}
#warning-message {
    margin: 0;
}
#warning-message-server {
    margin: 0;
}
#warning-pipe {
    margin: 0;
}


/* .warning {
    background-color: rgb(143, 81, 81);
    color: rgb(221, 221, 221);
    text-align:justify;
    margin: 0em;
    padding: 0em;
    border-radius: 10px;
    box-shadow: 0 4px 4px 0 rgba(0,0,0,0.10),0 5px 5px 0 rgba(0,0,0,0.08);box-shadow: 4px rgba(0,0,0,0.10),4px rgba(0,0,0,0.08);
    display: grid;
    grid-template-columns: 1fr 2fr;
    grid-template-areas: 
        "warning-title warning-login"
        "warning-title warning-server";
}

#warning-header {
    display: flex;
    text-align: center;
    margin: 0;
    padding: 0em 1em;
    grid-area: warning-title;
    align-items: center;
    justify-items: center;
    flex-grow: 1;
    border: 1em;
}
#warning-message {
    font-size: 18px;
    text-align: center;
    margin: 0;
    padding: .25em;
    grid-area: warning-login;
    align-items: center;
    justify-items: center;
}
#warning-message-server {
    font-size: 18px;
    text-align: center;
    margin: 0;
    padding: .25em;
    grid-area: warning-server;
    align-items: center;
    justify-items: center;
} */

</style>