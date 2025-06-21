//
//  ContentView.swift
//  q6
//
//  Created by Cromwell on 4/25/25.
//

import SwiftUI

struct ContentView: View
{
    @State private var input: String = ""
    @State private var degree: String = "Undergraduate"
    @State private var state: String = "In State"
    @State private var dorm = false
    @State private var dining = false
    @State private var parking = false
    @State private var totalCost: Float = 0.0

    var body: some View
    {
        VStack(spacing: 20)
        {
            TextField("Enter credit hours:", text: $input)
                .keyboardType(.decimalPad)
                .frame(width: 300, height: 50)
                .font(.system(size: 30))
                .background(Color.green)
                .foregroundColor(.red)
                .multilineTextAlignment(.center)
            
            // Degree picker
            Picker("Degree", selection: $degree)
            {
                Text("Undergraduate").tag("Undergraduate")
                Text("Graduate").tag("Graduate")
                Text("Non-Degree").tag("Non-Degree")
            }
            .pickerStyle(.segmented)
            .padding()

            // State picker
            Picker("State", selection: $state)
            {
                Text("In State").tag("In State")
                Text("Out of state").tag("Out of state")
            }
            .pickerStyle(.segmented)
            .padding()

            // Options
            Toggle("Dorm", isOn: $dorm)
                .background(Color.red)
                .padding()
            Toggle("Dining", isOn: $dining)
                .background(Color.red)
                .padding()
            Toggle("Parking", isOn: $parking)
                .background(Color.red)
                .padding()

            // Button
            Button("Calculate Total")
            {
                calculate()
            }
            .padding()
            .font(.title)
            .background(Color.blue)
            .foregroundColor(.white)
            .cornerRadius(10)

            // Output
            Text(String(format: "Total: $%.2f", totalCost))
                .font(.title2)
                .padding(.top, 30)
        }
        .padding()
        .frame(width: 400, height: 800)
        .background(Color.blue.opacity(0.1))
    }

    // Calculator logic
    func calculate()
    {
        guard let credits = Float(input) else
        {
            input = "0"
            totalCost = 0
            return
        }

        var tuition: Float = 0
        var additional: Float = 0

        if degree == "Graduate"
        {
            tuition = credits * 800
        } 
        else if degree == "Undergraduate"
        {
            tuition = credits * 500
        } else {
            tuition = credits * 300
        }

        if state == "Out of state"
        {
            tuition *= 2
        }

        if dorm {
            additional += 5000
        }
        if dining {
            additional += 2000
        }
        if parking {
            additional += 1000
        }

        totalCost = tuition + additional
    }
}

#Preview
{
    ContentView()
}
