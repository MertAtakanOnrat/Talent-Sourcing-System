import React, { useState, useEffect } from 'react';
import axios from 'axios';

function CandidateList() {
  const [candidates, setCandidates] = useState([]);

  useEffect(() => {
    async function fetchCandidates() {
        const response = await axios.get('/candidates');
        setCandidates(response.data);
    }
    fetchCandidates();
  }, []);

  console.log(candidates); // log the candidates array in the console

  return (
    <div>
      <h2>Candidates</h2>
      <ul>
        {candidates.map(candidate => (
          <li key={candidate.id}>
            <h3>{candidate.name}</h3>
            <p>ID: {candidate.id}</p> {/* add this line to display the ID */}
            <p>{candidate.contactInfo}</p>
            <ul>
              {candidate.interactions.map(interaction => (
                <li key={interaction}>{interaction}</li>
              ))}
            </ul>
            <p>{candidate.status}</p>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default CandidateList;
