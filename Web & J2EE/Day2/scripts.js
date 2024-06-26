function sortTable(n) {
    const table = document.getElementById("policyTable");
    let rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
    switching = true;
    dir = "asc"; 
    while (switching) {
        switching = false;
        rows = table.rows;
        for (i = 1; i < (rows.length - 1); i++) {
            shouldSwitch = false;
            x = rows[i].getElementsByTagName("TD")[n];
            y = rows[i + 1].getElementsByTagName("TD")[n];
            if (dir === "asc") {
                if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                    shouldSwitch = true;
                    break;
                }
            } else if (dir === "desc") {
                if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                    shouldSwitch = true;
                    break;
                }
            }
        }
        if (shouldSwitch) {
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
            switchcount++;
        } else {
            if (switchcount === 0 && dir === "asc") {
                dir = "desc";
                switching = true;
            }
        }
    }
}

function viewPolicy(policyId) {
    const policyDetails = {
        1: {
            id: 1,
            name: "Policy A",
            type: "Health",
            premium: "$100",
            details: "This is the detailed description of Policy A."
        },
        2: {
            id: 2,
            name: "Policy B",
            type: "Life",
            premium: "$200",
            details: "This is the detailed description of Policy B."
        }
    };

    const policy = policyDetails[policyId];
    document.getElementById('policyModalLabel').innerText = `Policy ${policy.name}`;
    document.getElementById('policyDetails').innerText = `ID: ${policy.id}\nName: ${policy.name}\nType: ${policy.type}\nPremium: ${policy.premium}\nDetails: ${policy.details}`;
}