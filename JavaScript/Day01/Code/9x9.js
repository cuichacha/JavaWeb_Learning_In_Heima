window.document.write("<table>");

// for (let i = 1; i <= 9; i++) {
//     window.document.write("<tr>");
//     for (let j = 1; j <= i; j++) {
//         window.document.write("<td>");
//         window.document.write(i + "*" + j + "=" + i * j);
//         window.document.write("</td>");
//     }
//     window.document.write("</tr>");
// }

for (let i = 9; i >= 1; i--) {
    window.document.write("<tr>");
    for (let j = 1; j <= i; j++) {
        window.document.write("<td>");
        window.document.write(i + "*" + j + "=" + i * j);
        window.document.write("</td>");
    }
    window.document.write("</tr>");
}
window.document.write("</table>");
