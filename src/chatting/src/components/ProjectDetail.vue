<template>
  <div class="projectDetail-container">
    <Notice />
    <Chat />
    projectDetail
  </div>
</template>

<script>

import Notice from "@/components/Notice.vue";
import Chat from "@/components/Chat.vue";
import '../../public/reset.css'

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