<template>
  <div class="projectDetail-container">
    <Notice />
    <Chat />
    projectDetail
    <router-view></router-view>
  </div>
</template>

<script>

import Notice from "@/components/popup/Notice.vue";
import Chat from "@/components/popup/Chat.vue";

export default {
  components: {
    Notice,
    Chat,
  },
};
</script>

<style>
.projectDetail-container {
  position: relative;
  width: 100%;
  height: calc(100vh - 70px);
  background: #16161a;
  overflow: hidden;
  color: white;
}
</style>