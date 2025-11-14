const toggle = document.getElementById("theme-toggle");
const dashboard = document.querySelector(".dashboard");

function applyTheme(theme) {
  dashboard.dataset.theme = theme;
  localStorage.setItem("theme", theme);


  toggle.textContent = theme === "dark" ? "🌞 Light Mode" : "🌙 Dark Mode";
}


toggle.addEventListener("click", () => {
  const newTheme = dashboard.dataset.theme === "light" ? "dark" : "light";
  applyTheme(newTheme);
});


window.addEventListener("DOMContentLoaded", () => {
  const savedTheme = localStorage.getItem("theme");

  if (savedTheme) {
    applyTheme(savedTheme);
  } else {
    const prefersDark = window.matchMedia("(prefers-color-scheme: dark)").matches;
    applyTheme(prefersDark ? "dark" : "light");
  }
});
